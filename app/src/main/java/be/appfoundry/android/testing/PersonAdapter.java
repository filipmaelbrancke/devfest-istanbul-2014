package be.appfoundry.android.testing;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import be.appfoundry.android.testing.model.Person;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.squareup.picasso.Picasso;
import java.util.List;

/**
 * Adapter between the BigBang characters and a listview.
 */
public class PersonAdapter extends ArrayAdapter<Person> {

    private static final String imageUrl = "https://appfoundry-restdemo.herokuapp.com/";

    //private final List<Person> persons;

    public PersonAdapter(Context context, List<Person> persons) {
        super(context, R.layout.list_item, persons);
        //this.persons = persons;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
            holder = new ViewHolder(convertView);
            //holder.image = (ImageView) convertView.findViewById(R.id.list_item_photo);
            //holder.label = (TextView) convertView.findViewById(R.id.list_item_label);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        final Person person = getItem(position);

        holder.label.setText(person.getFullName());

        Picasso.with(getContext()).load(imageUrl + person.getImageUri()).into(holder.image);
        return convertView;
    }

     class ViewHolder {
        @InjectView(R.id.list_item_photo)
        ImageView image;

        @InjectView(R.id.list_item_label)
        TextView label;

        public ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
