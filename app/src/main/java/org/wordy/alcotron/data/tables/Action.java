package org.wordy.alcotron.data.tables;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import org.json.JSONException;
import org.json.JSONObject;

@Entity(tableName = "action")
public class Action {

    @PrimaryKey
    private int id;
    private int langId;
    private String name;
    private int selectId;

    public Action() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLangId() {
        return langId;
    }

    public void setLangId(int langId) {
        this.langId = langId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSelectId() {
        return selectId;
    }

    public void setSelectId(int selectId) {
        this.selectId = selectId;
    }

    public static JSONObject toJson(Action action) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("langId", action.langId);
            jsonObject.put("name", action.name);
            jsonObject.put("selectId", 1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public static Action fromJson(JSONObject jsonObject) throws JSONException {
        Action action = new Action();
        action.id = jsonObject.getInt("id");
        action.langId = jsonObject.getInt("langId");
        action.name = jsonObject.getString("name");
        action.selectId = 0;
        return action;
    }

}
