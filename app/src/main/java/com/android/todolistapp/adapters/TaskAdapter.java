package com.android.todolistapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.android.todolistapp.R;
import com.android.todolistapp.models.Task;

import java.util.List;

public class TaskAdapter extends BaseAdapter {

    LayoutInflater layoutInflater;
    List<Task> tasklist;


    public TaskAdapter(LayoutInflater layoutInflater, List<Task> tasklist) {


        this.layoutInflater=layoutInflater;
        this.tasklist = tasklist;
    }


    static  class ViewHolder{
        protected TextView text;
        protected CheckBox checkBox;
    }

    @Override
    public int getCount() {
        return tasklist.size();
    }

    @Override
    public Object getItem(int position) {
        return tasklist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent){
        View view=null;

        if(convertView==null){

            view=layoutInflater.inflate(R.layout.custom_listview_item,null);

            final ViewHolder viewHolder=new ViewHolder();
            viewHolder.text=(TextView)view.findViewById(R.id.txtViewTaskName);
            viewHolder.checkBox=(CheckBox)view.findViewById(R.id.checkbox);
            viewHolder.checkBox
                    .setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            Task element=(Task)viewHolder.checkBox.getTag();
                            element.setStatus(buttonView.isChecked());

                        }
                    });
            view.setTag(viewHolder);
            viewHolder.checkBox.setTag(tasklist.get(position));
        }else {
            view=convertView;
            ((ViewHolder)view.getTag()).checkBox.setTag(tasklist.get(position));
        }
        final ViewHolder holder=(ViewHolder)view.getTag();
        holder.text.setText(tasklist.get(position).getTaskName());
        holder.checkBox.setChecked(tasklist.get(position).isStatus());


        return view;
    }
}
