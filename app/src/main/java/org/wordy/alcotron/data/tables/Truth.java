package org.wordy.alcotron.data.tables;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import org.json.JSONException;
import org.json.JSONObject;

@Entity(tableName = "truth")
public class Truth {

    @PrimaryKey
    private int id;
    private int langId;
    private String name;
    private int selectId;

    public Truth() {
    }

    public Truth(int langId, String name, int selectId) {
        this.langId = langId;
        this.name = name;
        this.selectId = selectId;
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

    public static JSONObject toJson(Truth truth) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("langId", truth.langId);
            jsonObject.put("name", truth.name);
            jsonObject.put("selectId", 1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public static Truth fromJson(JSONObject jsonObject) {
        Truth truth = new Truth();
        try {
            truth.id = jsonObject.getInt("id");
            truth.langId = jsonObject.getInt("langID");
            truth.name = jsonObject.getString("name");
            truth.selectId = 0;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return truth;
    }

}
