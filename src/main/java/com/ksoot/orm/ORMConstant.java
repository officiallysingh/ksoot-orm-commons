/*
 * Copyright 2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ksoot.orm;

/**
 * ORM constants.
 */
public interface ORMConstant {

	// ID Generation strategies starts >>>
	String GLOBAL_SEQ_ID_GENERATOR = "GLOBAL_SEQ_ID_GENERATOR";

	String GUID_GENERATOR = "GUID_GENERATOR";

	String UUID2_GENERATOR = "UUID2_GENERATOR";

	// ID Generation strategies ends >>>

	String GLOBAL_SEQ_NAME = "global_sequence";

	String GLOBAL_SEQ_INITIAL_VALUE = "1000";

}
