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

package com.ksoot.orm.jpa.model;

import static com.ksoot.orm.ORMConstant.GLOBAL_SEQ_ID_GENERATOR;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @param <IdType> Id type
 * 
 * @author Rajveer Singh
 */
@MappedSuperclass
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public abstract class AbstractIdentifiable<IdType extends Number & Comparable<IdType> & Serializable>
		implements Identifiable<IdType> {
	
	@Id
	@GeneratedValue(generator = GLOBAL_SEQ_ID_GENERATOR)
	@Column(name = "ID", updatable = false, nullable = false)
	@Access(AccessType.FIELD)
	protected IdType id;
	
	@Override
	public IdType id() {
		return id;
	}
}
