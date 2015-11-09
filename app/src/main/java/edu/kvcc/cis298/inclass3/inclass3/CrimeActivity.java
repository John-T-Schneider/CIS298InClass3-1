package edu.kvcc.cis298.inclass3.inclass3;


import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;

import java.util.UUID;

public class CrimeActivity extends SingleFragmentActivity {

private static final String EXTRA_CRIME_ID =
        "edu.kvcc.cis298.inclass3.inclass3.crime_id";

    //This method is public an static so that ANY other activity or fragment that
    // might want to start this Activity can get a properly formatted intet that
    // will allow this activity to start successfully
    public static Intent newIntent(Context packageContext, UUID crimeID){
        //make new intent
        Intent intent = new Intent(packageContext, CrimeActivity.class);
        //put the passed in crimeID
        intent.putExtra(EXTRA_CRIME_ID, crimeID);
        return intent;
    }


    @Override
    protected Fragment createFragment() {

        //Get the UUID from the Extras for the activity. Since UUID is not a simple type such as
        // int or double, it must be of a type that implements the serializable interface. UUID does
        // implement serializable, so it can be sent through as an Extra using the serializable type
        //We didn't have to do anything with serializable. We just needed to know that UUID is
        // serializable, and so that is the method we used to store and retrieve it. Since it arrives
        // here as serializable, it must be cast to a UUID. That is the (UUID) part.
        UUID crimeId = (UUID) getIntent().getSerializableExtra(EXTRA_CRIME_ID);

        //Return a CrimeFragment that is created by calling the static method CrimeFragment called
        //newInstance. The method takes in a UUID and then returns a new Instance of the
        //CrimeFragment by getting the UUID from the Extras of the intent above, and then sending it
        //over to the fragment through this method, we have decoupled the fragment from the activity
        return CrimeFragment.newInstance(crimeId);
    }
}









