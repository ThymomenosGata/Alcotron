package org.wordy.alcotron.screens.splash;

import android.app.Application;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.wordy.alcotron.data.Dao.ActionDao;
import org.wordy.alcotron.data.Dao.I_NeverDao;
import org.wordy.alcotron.data.Dao.TruthDao;
import org.wordy.alcotron.data.DataBase;
import org.wordy.alcotron.data.PortalRest;
import org.wordy.alcotron.data.tables.Action;
import org.wordy.alcotron.data.tables.I_Never;
import org.wordy.alcotron.data.tables.Truth;

import java.io.IOException;

public class SplashModel implements SplashContract.Model {

    private PortalRest mPortal;
    private ActionDao actionDao;
    private I_NeverDao i_neverDao;
    private TruthDao truthDao;

    public SplashModel(Application application) {
        DataBase dataBase = DataBase.getDatabase(application);
        this.mPortal = PortalRest.getPortal();
        this.actionDao = dataBase.actionDao();
        this.truthDao = dataBase.truthDao();
        this.i_neverDao = dataBase.i_neverDao();
    }

    public boolean getActions() {
        try {
            JSONArray jsonArray = new JSONArray(mPortal.get("action", String.valueOf(actionDao.getMaxId())).body().string());
            for (int i = 0; i < jsonArray.length(); i++) {
                try {
                    JSONObject json = jsonArray.getJSONObject(i);
                    actionDao.insert(Action.fromJson(json));
                } catch (JSONException e) {
                    return false;
                }
            }
            return true;
        } catch (JSONException | IOException e) {
            return false;
        }
    }

    public boolean getTruth() {
        try {
            JSONArray jsonArray = new JSONArray(mPortal.get("truth", String.valueOf(truthDao.getMaxId())).body().string());
            for (int i = 0; i < jsonArray.length(); i++) {
                try {
                    JSONObject json = jsonArray.getJSONObject(i);
                    truthDao.insert(Truth.fromJson(json));
                } catch (JSONException e) {
                    return false;
                }
            }
            return true;
        } catch (JSONException | IOException e) {
            return false;
        }
    }

    public boolean getNevers() {
        try {
            JSONArray jsonArray = new JSONArray(mPortal.get("never", String.valueOf(i_neverDao.getMaxId())).body().string());
            for (int i = 0; i < jsonArray.length(); i++) {
                try {
                    JSONObject json = jsonArray.getJSONObject(i);
                    i_neverDao.insert(I_Never.fromJson(json));
                } catch (JSONException e) {
                    return false;
                }
            }
            return true;
        } catch (JSONException | IOException e) {
            return false;
        }
    }

}
