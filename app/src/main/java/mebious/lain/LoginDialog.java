package mebious.lain;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.view.MotionEvent;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.graphics.Color;

/**
 * Login dialog custom drawing element
 */
public class LoginDialog extends View {

    /* The circle behind the login field */
    private Paint loginCircle;

    public LoginDialog(Context context) {
        super(context);
        init(context, null);
    }

    public LoginDialog(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    /* Constructor, attrs can be null if needed */
    private void init(Context context, AttributeSet attrs) {

        Log.e("ERROR", "initializing LoginDialog!");

        loginCircle = new Paint();
        loginCircle.setColor(Color.parseColor("#ff6347"));
        loginCircle.setAntiAlias(true);
        loginCircle.setStyle(Paint.Style.FILL);

        // attrs ignored
    }

        @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        final int width = getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec);
        final int height = getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec);
        final int min = Math.min(width, height);

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(0.0f, 0.0f, 100.0f, 100.0f, loginCircle);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        Log.d("ERROR", "touch event!");

        this.getParent().requestDisallowInterceptTouchEvent(true);

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e("ERROR", "down!");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e("ERROR", "move!");
                break;
            case MotionEvent.ACTION_UP:
                Log.e("ERROR", "up!");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.e("ERROR", "cancel!");
                break;
        }

        return true;
    }

    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }
}
