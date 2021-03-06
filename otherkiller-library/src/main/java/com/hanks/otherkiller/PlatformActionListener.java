/*
 * Copyright (c)  2015 hanks ( https://github.com/hanks-zyh ).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hanks.otherkiller;
import java.util.HashMap;
/**
 * callback for share
 * <p>
 * Created by hanks on 15-11-26.
 */
public interface PlatformActionListener {

    int RESULT_COMPLETE = 0x200;
    int RESULT_ERROR    = 0x201;
    int RESULT_CANCEL   = 0x202;

    void onComplete(int platform, int code, HashMap<String, Object> var3);

    void onError(int platform, int code, Throwable var3);

    void onCancel(int platform, int code);
}
