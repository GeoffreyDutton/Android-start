package io.bloc.android.blocly;

import android.app.Application;

import io.bloc.android.blocly.api.DataSource;

/**
 * Created by Geoff on 2/16/2017.
 */

public class BloclyApplication extends Application{

    public static BloclyApplication getSharedInstance(){
        return sharedInstance;
    }

    public static DataSource getSharedDataSource(){
        return BloclyApplication.getSharedInstance().getDataSource();
    }

    private static BloclyApplication sharedInstance;
    private DataSource dataSource;

    @Override
    public void onCreate(){
        super.onCreate();
        sharedInstance = this;
        dataSource = new DataSource();
    }

    public DataSource getDataSource(){
        return dataSource;
    }
}
