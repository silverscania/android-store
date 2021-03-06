/*
 * Copyright (C) 2012 Soomla Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.soomla.store.domain.virtualCurrencies;

import com.soomla.store.data.StorageManager;
import com.soomla.store.domain.VirtualItem;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This is a representation of a game's virtual currency.
 * Each game can have multiple instances of a virtual currency, all kept in {@link com.soomla.store.data.StoreInfo};
 */
public class VirtualCurrency extends VirtualItem {

    /** Constructor
     * see parent
     */
    public VirtualCurrency(String mName, String mDescription, String itemId) {
        super(mName, mDescription, itemId);
    }

    /** Constructor
     *
     * see parent
     */
    public VirtualCurrency(JSONObject jsonObject) throws JSONException {
        super(jsonObject);
    }

    /**
     * see parent
     */
    public JSONObject toJSONObject(){
        return super.toJSONObject();
    }

    /**
     * see parent
     * @param amount the amount of the specific item to be given.
     */
    @Override
    public void give(int amount) {
        StorageManager.getVirtualCurrencyStorage().add(this, amount);
    }

    /**
     * see parent
     * @param amount the amount of the specific item to be taken.
     */
    @Override
    public void take(int amount) {
        StorageManager.getVirtualCurrencyStorage().remove(this, amount);
    }
}
