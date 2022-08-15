package sg.edu.rp.c346.id20041194.L13ProblemStatement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<HospitalRecords> versionList;

    public CustomAdapter(Context context, int resource,
                         ArrayList<HospitalRecords> objects) {
        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        versionList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
            // Obtain the LayoutInflater object
            LayoutInflater inflater = (LayoutInflater)
                    parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            // "Inflate" the View for each row
            View rowView = inflater.inflate(layout_id, parent, false);

            // Obtain the UI components and do the necessary binding
            TextView tv1 = rowView.findViewById(R.id.HospitalTitle);
            TextView tvFacilityType = rowView.findViewById(R.id.tvFac);
            TextView tvnoofbeds = rowView.findViewById(R.id.tvBeds);
            TextView tvnooffacilities = rowView.findViewById(R.id.tvFacis);
            TextView tvYear = rowView.findViewById(R.id.tvYear);
            TextView ASS = rowView.findViewById(R.id.HospitalTitle);
            // Obtain the Android Version information based on the position
            HospitalRecords currentVersion = versionList.get(position);

            // Set values to the TextView to display the corresponding information
            tv1.setText("Hospital");
            tvFacilityType.setText(currentVersion.getInstitution());
            tvFacilityType.setText(currentVersion.getFacility());
            tvnoofbeds.setText(currentVersion.getBeds());
            tvnooffacilities.setText(currentVersion.getFacilityNo());
            tvYear.setText(currentVersion.getYear());

            return rowView;
        }


    }

