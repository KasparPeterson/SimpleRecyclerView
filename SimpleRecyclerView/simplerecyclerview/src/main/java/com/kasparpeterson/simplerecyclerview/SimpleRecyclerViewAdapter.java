package com.kasparpeterson.simplerecyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kaspar on 18/02/2017.
 */

public class SimpleRecyclerViewAdapter<L>
        extends RecyclerView.Adapter<SimpleRecyclerViewAdapter.SimpleViewHolder> {

    @NonNull
    private final L listener;

    private Map<Integer, SimpleViewType> viewTypes = new HashMap<>();
    private List<SimpleAdapterItem> adapterItems = new ArrayList<>();

    public SimpleRecyclerViewAdapter(@NonNull List<SimpleAdapterItem> adapterItems, @NonNull L listener) {
        this.listener = listener;
        setAdapterItems(adapterItems);
    }

    public void setAdapterItems(@NonNull List<SimpleAdapterItem> adapterItems) {
        for (SimpleAdapterItem item : adapterItems) {
            viewTypes.put(item.getViewType().getViewTypeAsInt(), item.getViewType());
        }
        this.adapterItems.clear();
        this.adapterItems.addAll(adapterItems);
        notifyDataSetChanged();
    }

    @Override
    public SimpleRecyclerViewAdapter.SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        try {
            return viewTypes.get(viewType)
                    .getViewHolder(LayoutInflater.from(parent.getContext()), parent);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onBindViewHolder(SimpleViewHolder holder, int position) {
        // This has to be overridden but it is actually never called by the system.
    }

    @Override
    public void onBindViewHolder(SimpleViewHolder holder, int position, List<Object> payloads) {
        holder.onBind(adapterItems.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return adapterItems.size();
    }

    @Override
    public int getItemViewType(int position) {
        return adapterItems.get(position).getViewType().getViewTypeAsInt();
    }

    public List<SimpleAdapterItem> getAdapterItems() {
        return adapterItems;
    }

    public static abstract class SimpleViewHolder<I extends SimpleAdapterItem, L> extends RecyclerView.ViewHolder {

        public SimpleViewHolder(View itemView) {
            super(itemView);
        }

        public abstract void onBind(@NonNull I item, @NonNull L listener);

    }

}
