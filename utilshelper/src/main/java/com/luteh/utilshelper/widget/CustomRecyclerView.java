package com.luteh.utilshelper.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class CustomRecyclerView extends RecyclerView {

    private View emptyView;

    private View headerView;

    final private AdapterDataObserver observer = new AdapterDataObserver() {
        @Override
        public void onChanged() {
            checkIfEmpty();
        }

        @Override
        public void onItemRangeInserted(int positionStart, int itemCount) {
            checkIfEmpty();
        }

        @Override
        public void onItemRangeRemoved(int positionStart, int itemCount) {
            checkIfEmpty();
        }
    };

    public CustomRecyclerView(Context context) {
        super(context);
    }

    public CustomRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    //----------------------------------------------------------------------------------------------
    // Empty View
    //----------------------------------------------------------------------------------------------

    public CustomRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    void checkIfEmpty() {
        if (getAdapter() == null)
            return;

        boolean emptyViewVisible = getAdapter().getItemCount() <= 0;
        if (emptyView != null) {
            emptyView.setVisibility(emptyViewVisible ? VISIBLE : GONE);
        }
        if (headerView != null) {
            headerView.setVisibility(emptyViewVisible ? GONE : VISIBLE);
        }
        setVisibility(emptyViewVisible ? GONE : VISIBLE);
    }

    @Override
    public void setAdapter(Adapter adapter) {
        final Adapter oldAdapter = getAdapter();
        if (oldAdapter != null) {
            oldAdapter.unregisterAdapterDataObserver(observer);
        }

        super.setAdapter(adapter);
        if (adapter != null) {
            adapter.registerAdapterDataObserver(observer);
        }

        checkIfEmpty();
    }

    public void setEmptyView(View emptyView) {
        this.emptyView = emptyView;
        checkIfEmpty();
    }

    //----------------------------------------------------------------------------------------------
    // Empty View
    //----------------------------------------------------------------------------------------------

    public void setHeaderView(View headerView) {
        this.headerView = headerView;
        checkIfEmpty();
    }
}

