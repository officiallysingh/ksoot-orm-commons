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

//@formatter:off
@GenericGenerators({
	@GenericGenerator(
		name = GLOBAL_SEQ_ID_GENERATOR,
		strategy = "enhanced-sequence",
		parameters = {
			@Parameter(name = "sequence_name", value = GLOBAL_SEQ_NAME),
			@Parameter(name = "initial_value", value = GLOBAL_SEQ_INITIAL_VALUE),
			@Parameter(name = "increment_size", value = "1")
		}
	),
    // Produces a unique 128-bit UUID in the application layer
    @GenericGenerator(
        name = UUID2_GENERATOR,
        strategy = "org.hibernate.id.UUIDGenerator",
        parameters = {
            @Parameter(name = "uuid_gen_strategy_class", value = "org.hibernate.id.uuid.CustomVersionOneStrategy")
        }
    )
})
//@formatter:on

package com.ksoot.orm.dao;

import static com.ksoot.orm.ORMConstant.GLOBAL_SEQ_ID_GENERATOR;
import static com.ksoot.orm.ORMConstant.GLOBAL_SEQ_INITIAL_VALUE;
import static com.ksoot.orm.ORMConstant.GLOBAL_SEQ_NAME;
import static com.ksoot.orm.ORMConstant.UUID2_GENERATOR;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.GenericGenerators;
import org.hibernate.annotations.Parameter;