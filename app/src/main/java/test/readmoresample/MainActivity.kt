package test.readmoresample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import butterknife.bindView

class MainActivity : AppCompatActivity() {
    val contentTextView: TextView by bindView(R.id.content)
    val readMoreButton: Button by bindView(R.id.read_more)
    val setLongContentButton: Button by bindView(R.id.long_content)
    val setShortContentButton: Button by bindView(R.id.short_content)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.setUpContentTextView()

        this.readMoreButton.setOnClickListener {
            this.contentTextView.maxLines = Integer.MAX_VALUE
            this.readMoreButton.visibility = View.GONE
        }

        this.setLongContentButton.setOnClickListener {
            this.contentTextView.text = this.getString(R.string.long_content)
            this.setUpContentTextView()
        }

        this.setShortContentButton.setOnClickListener {
            this.contentTextView.text = this.getString(R.string.short_content)
            this.setUpContentTextView()
        }
    }

    private fun setUpContentTextView() {
        val MAX_LINES = 3

        this.contentTextView.post {
            val needTruncate = (contentTextView.lineCount > MAX_LINES)
            if (needTruncate) {
                this.contentTextView.maxLines = MAX_LINES
                this.readMoreButton.visibility = View.VISIBLE
                return@post
            }

            if (contentTextView.isTextTruncated()) {
                this.readMoreButton.visibility = View.VISIBLE
            } else {
                this.readMoreButton.visibility = View.GONE
            }
        }
    }
}
