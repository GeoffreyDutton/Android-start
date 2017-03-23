package io.bloc.android.blocly.api.model;

/**
 * Created by Geoff on 3/22/2017.
 */

public abstract class Model {
    private final long rowID;

    public Model(long rowID){
        this.rowID = rowID;
    }

    public long getRowId(){
        return rowID;
    }
}
