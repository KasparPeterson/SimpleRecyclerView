package com.kasparpeterson.simplerecyclerview;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by kaspar on 19/02/2017.
 */

public class ExampleAdapter extends SimpleRecyclerViewAdapter<ExampleAdapter.Listener> {

    public interface Listener {
        void onFirstItemClicked(@NonNull String input);
        void onSecondItemClicked();
    }

    public ExampleAdapter(@NonNull List<SimpleAdapterItem> adapterItems, @NonNull Listener listener) {
        super(adapterItems, listener);
    }

    public static class FirstItem extends SimpleAdapterItem {

        private final String input;

        public FirstItem(@NonNull String input) {
            super(0, R.layout.view_first, FirstItem.FirstItemViewHolder.class);
            this.input = input;
        }

        public static class FirstItemViewHolder extends SimpleViewHolder<FirstItem, Listener> {

            private final TextView textView;
            private final Button button;

            public FirstItemViewHolder(View itemView) {
                super(itemView);
                textView = (TextView) itemView.findViewById(R.id.view_first_text_view);
                button = (Button) itemView.findViewById(R.id.view_first_button);
            }

            @Override
            public void onBind(@NonNull final FirstItem item, @NonNull final Listener listener) {
                textView.setText(item.input);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        listener.onFirstItemClicked(item.input);
                    }
                });
            }
        }
    }

    public static class SecondItem extends SimpleAdapterItem {

        public SecondItem() {
            super(1, R.layout.view_second, SecondItem.SecondItemViewHolder.class);
        }

        public static class SecondItemViewHolder extends SimpleViewHolder<SecondItem, Listener> {

            private final View view;

            public SecondItemViewHolder(View itemView) {
                super(itemView);
                view = itemView;
            }

            @Override
            public void onBind(@NonNull SecondItem item, @NonNull final Listener listener) {
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        listener.onSecondItemClicked();
                    }
                });
            }
        }
    }

}
