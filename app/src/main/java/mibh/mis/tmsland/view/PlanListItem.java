package mibh.mis.tmsland.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Html;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import mibh.mis.tmsland.R;
import mibh.mis.tmsland.view.state.BundleSavedState;

public class PlanListItem extends BaseCustomViewGroup {

    private TextView tvItemNo,
            tvSource,
            tvDest,
            tvProduct;
    private LinearLayout viewDetail;

    public PlanListItem(Context context) {
        super(context);
        initInflate();
        initInstances();
    }

    public PlanListItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        initInflate();
        initInstances();
        initWithAttrs(attrs, 0, 0);
    }

    public PlanListItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initInflate();
        initInstances();
        initWithAttrs(attrs, defStyleAttr, 0);
    }

    @TargetApi(21)
    public PlanListItem(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initInflate();
        initInstances();
        initWithAttrs(attrs, defStyleAttr, defStyleRes);
    }

    private void initInflate() {
        inflate(getContext(), R.layout.plan_item, this);
    }

    private void initInstances() {
        tvItemNo = (TextView) findViewById(R.id.tvPlanItemNo);
        tvSource = (TextView) findViewById(R.id.tvPlanItemSource);
        tvDest = (TextView) findViewById(R.id.tvPlanItemDest);
        tvProduct = (TextView) findViewById(R.id.tvPlanItemProduct);
        viewDetail = (LinearLayout) findViewById(R.id.viewPlanListItemDetail);
    }

    private void initWithAttrs(AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        /*
        TypedArray a = getContext().getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.StyleableName,
                defStyleAttr, defStyleRes);

        try {

        } finally {
            a.recycle();
        }
        */
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();

        BundleSavedState savedState = new BundleSavedState(superState);
        // Save Instance State(s) here to the 'savedState.getBundle()'
        // for example,
        // savedState.getBundle().putString("key", value);

        return savedState;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        BundleSavedState ss = (BundleSavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());

        Bundle bundle = ss.getBundle();
        // Restore State from bundle here
    }

    public void setTextItemNo(String itemNo) {
        tvItemNo.setText("เส้นทาง No. " + itemNo);
    }

    public void setTextSource(String source) {
        tvSource.setText(source);
    }

    public void setTextDest(String dest) {
        tvDest.setText(dest);
    }

    public void setTextProduct(String product) {
        tvProduct.setText(Html.fromHtml(product.replace("ลง", "<font color='red'>ลง</font>").replace("ขึ้น", "<font color='blue'>ขึ้น</font>").replace("\n", "<br>")));
    }

    public void setOnClickDetail(OnClickListener onClickListener) {
        this.viewDetail.setOnClickListener(onClickListener);
    }

}
