package com.android.todolistapp.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.todolistapp.R;
import com.android.todolistapp.adapters.TaskAdapter;
import com.android.todolistapp.models.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TaskListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TaskListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TaskListFragment extends Fragment {

    List<Task> taskList = new ArrayList<Task>();
    int finishedTask,waitingTask=0;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public TaskListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TaskListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TaskListFragment newInstance(String param1, String param2) {
        TaskListFragment fragment = new TaskListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_tasklist,container,false);
        // Inflate the layout for this fragment

        taskList.add(new Task(true,"Ekmek Al"));
        taskList.add(new Task(true,"Temizlik"));
        taskList.add(new Task(false,"GYK Projesi Yap"));

        /*Bundle bundle=getArguments();
        String taskName=bundle.getString("TaskName");
        Boolean status=bundle.getBoolean("Status");
        taskList.add(new Task(status,taskName));*/


        // Listede tamamlanan ve bekleyen görevleri görmek için dönüyorum..
        // Sonuçları yine bundle ile diğer ekrandaki tamamlanan ve bekleyen görevler textview e yansıtmak için.
        for (Task item:taskList) {
            if(item.isStatus()==true){
                finishedTask++;
            }else {waitingTask++;}
        }

        Fragment profileFragmnet=new ProfileFragment();
        // Bu bundle2 profil ekranında tamamlanan ve bekleyen görevlere data göndermek için
        Bundle bundle2=new Bundle();
        bundle2.putInt("finished",finishedTask);
        bundle2.putInt("waiting",waitingTask);
        profileFragmnet.setArguments(bundle2);

        ListView listViewTask=(ListView)view.findViewById(R.id.listViewTask);
        TaskAdapter taskAdapter=new TaskAdapter(getLayoutInflater(),taskList);
        //taskAdapter.notifyDataSetChanged();
        listViewTask.setAdapter(taskAdapter);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // OnAttach içindeki super hariç diğer alanları silmeyince program has stopped hatası veriyor !!!
        // Burayı silmeyi unutma!!
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
