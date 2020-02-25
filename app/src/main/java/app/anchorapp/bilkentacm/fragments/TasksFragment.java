package app.anchorapp.bilkentacm.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import app.anchorapp.bilkentacm.R;
import app.anchorapp.bilkentacm.adapters.ChecklistAdapter;
import app.anchorapp.bilkentacm.models.TaskGroup;

/**
 * A simple {@link Fragment} subclass.
 */
public class TasksFragment extends Fragment {


    public TasksFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tasks, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.fragment_task_recycler_checklist);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        ArrayList<TaskGroup> list = new ArrayList<>();

        TaskGroup taskGroup6 = new TaskGroup(R.color.colorPrimary, 100, "ACM", getActivity().getDrawable(R.drawable.ic_tasks));
        TaskGroup taskGroup1 = new TaskGroup(R.color.colorPrimary, 3, "Environment", getActivity().getDrawable(R.drawable.ic_person));
        TaskGroup taskGroup2 = new TaskGroup(R.color.colorAccent, 3, "Environment", getActivity().getDrawable(R.drawable.ic_person));
        TaskGroup taskGroup3 = new TaskGroup(R.color.colorTest, 3, "Environment", getActivity().getDrawable(R.drawable.ic_person));
        TaskGroup taskGroup4 = new TaskGroup(R.color.colorAccent, 3, "Environment", getActivity().getDrawable(R.drawable.ic_person));

        list.add(taskGroup1);
        list.add(taskGroup2);
        list.add(taskGroup3);
        list.add(taskGroup4);
        list.add(taskGroup6);


        recyclerView.setAdapter(new ChecklistAdapter(list, getContext()));

        synchronized (recyclerView) {
            recyclerView.notifyAll();
        }
        return view;
    }

}
