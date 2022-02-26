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

package com.ksoot.orm.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 * @author Rajveer Singh
 */
public interface JPA {

	public <T> Optional<T> getSingleResultSafely(final CriteriaQuery<T> criteriaQuery);

	public <T> Optional<T> getSingleResultSafely(final TypedQuery<T> typedQuery);

	public <T> Optional<T> getSingleResultSafely(final Query query);

	public <T> List<T> getUnmodifiableResultList(final CriteriaQuery<T> query);

	public <T> List<T> getUnmodifiableResultList(final TypedQuery<T> query);

	public <T> T persist(final T entity);

	public <T, P> Optional<T> findByIdSafely(final Class<T> clazz, final P primaryKey);

	public <T, P> T getReference(final Class<T> clazz, final P primaryKey);

	public EntityManager entityManager();

	public CriteriaBuilder criteriaBuilder();

	public <T> CriteriaQuery<T> criteriaQuery(final Class<T> clazz);

	public <T> TypedQuery<T> typedQuery(CriteriaQuery<T> criteriaQuery);

}
