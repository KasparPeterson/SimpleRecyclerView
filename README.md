# SimpleRecyclerView
Simple wrapper to RecyclerView adapter. Removes all the hassle with if checks in your recycler view adapter onBind and createViewHolder callbacks. Provide just AdapterItems to RecyclerView adapter that have layout resource id and onBind callback. That's it.

### Example

```
public class CoolAdapter extends SimpleRecyclerViewAdapter<CoolAdapter.Listener> {

  public interface Listener {
    void onDoSomething(String something);
  }
  
  public static class FirstItem extends SimpleAdapterItem {
  
    public FirstItem(String maybeNeedSomething??) {
      super(0, R.layout.my_id, FirstItem.FirstItemViewHolder.class);
    }
    
    public static class FirstItemViewHolder extends SimpleViewHolder<FirstItem, Listener> {
    
      public FirstItemViewHolder(View itemView) {
        super(itemView);
        // Remember views
      }

      @Override
      public void onBind(@NonNull AdapterItem item, @NonNull Listener listener) {
        // Bind views. See that listener is also in here.
      }
    }
  }
  
  public static class SecondItem....
}
```
