package org.wordy.alcotron.data.tables;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import org.json.JSONException;
import org.json.JSONObject;

@Entity(tableName = "i_never")
public class I_Never {

    @PrimaryKey
    private int id;
    private int langId;
    private String name;
    private int selectId;

    public I_Never() {
    }

    public I_Never(int langId, String name, int selectId) {
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

    public static JSONObject toJson(I_Never never) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("id", 0);
            jsonObject.put("langId", never.langId);
            jsonObject.put("name", never.name);
            jsonObject.put("selectId", 1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public static I_Never fromJson(JSONObject jsonObject) {
        I_Never i_never = new I_Never();
        try {
            i_never.id = jsonObject.getInt("id");
            i_never.langId = jsonObject.getInt("langID");
            i_never.name = jsonObject.getString("name");
            i_never.selectId = 0;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return i_never;
    }
}
