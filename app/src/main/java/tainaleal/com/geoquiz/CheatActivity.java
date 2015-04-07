package tainaleal.com.geoquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by tainaleal on 4/1/15.
 */
public class CheatActivity extends Activity {

    public static final String EXTRA_ANSWER_IS_TRUE = "com.tainaleal.geoquiz.answer_is_true";
    public static final String EXTRA_ANSWER_IS_SHOWN = "com.tainaleal.geoquiz.answer_is_shown";
    private boolean mBooleanAnswer;
    private Button mShowAnswerButton;
    private TextView mShowAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        mBooleanAnswer = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);

        mShowAnswerButton = (Button)findViewById(R.id.showAnswerButton);
        mShowAnswer = (TextView)findViewById(R.id.answer);
        setExtraAnswerIsShown(false);


        mShowAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mBooleanAnswer)
                    mShowAnswer.setText(R.string.true_button);
                else
                    mShowAnswer.setText(R.string.false_button);

                setExtraAnswerIsShown(true);
            }
        });

    }

    private void setExtraAnswerIsShown(boolean answerIsShown)
    {
        Intent intent = new Intent();
        intent.putExtra(EXTRA_ANSWER_IS_SHOWN, answerIsShown);
        setResult(RESULT_OK, intent);
    }

}
