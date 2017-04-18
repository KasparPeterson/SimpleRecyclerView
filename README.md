# SimpleRecyclerView
Simple wrapper to RecyclerView adapter. Removes all the hassle with if checks in your recycler view adapter onBind and createViewHolder callbacks. Provide just AdapterItems to RecyclerView adapter that have layout resource id and onBind callback. That's it.

Get's rid of:
* onCreateViewHolder()
* onBindViewHolder()
* getItemCount()
* getItemViewType()

### Example

```
public class CoolAdapter extends SimpleRecyclerViewAdapter<CoolAdapter.MyListener> {

  public interface MyListener {
    void onDoSomething(String something);
  }
  
  // This has to be public as it is accessed from outside.
  public static class FirstItem extends SimpleAdapterItem {
  
    public FirstItem(String maybeNeedSomething??) {
      super(0, R.layout.my_id, FirstItem.FirstItemViewHolder.class);
    }
    
    // This has to be public as it is accessed from outside.
    public static class FirstItemViewHolder extends SimpleViewHolder<FirstItem, MyListener> {
    
      public FirstItemViewHolder(View itemView) {
        super(itemView);
        // Remember views
      }

      @Override
      public void onBind(@NonNull AdapterItem item, @NonNull MyListener listener) {
        // Bind views. See that listener is also in here.
      }
    }
  }
  
  public static class SecondItem....
}
```
