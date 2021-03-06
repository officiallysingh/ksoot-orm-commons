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

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 * @author Rajveer Singh
 */
public abstract class AbstractJPA implements JPA {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public EntityManager entityManager() {
		return this.entityManager;
	}

	@Override
	public CriteriaBuilder criteriaBuilder() {
		return entityManager().getCriteriaBuilder();
	}

	@Override
	public <T> CriteriaQuery<T> criteriaQuery(final Class<T> clazz) {
		return criteriaBuilder().createQuery(clazz);
	}

	@Override
	public <T> TypedQuery<T> typedQuery(CriteriaQuery<T> criteriaQuery) {
		return entityManager().createQuery(criteriaQuery);
	}

	@Override
	public <T> Optional<T> getSingleResultSafely(final CriteriaQuery<T> criteriaQuery) {
		return getSingleResultSafely(entityManager().createQuery(criteriaQuery));
	}

	@Override
	public <T> Optional<T> getSingleResultSafely(final TypedQuery<T> typedQuery) {
		T result = null;
		try {
			result = typedQuery.getSingleResult();
		}
		catch (NoResultException nsre) {
			// Ignore
		}
		return Optional.ofNullable(result);
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T> Optional<T> getSingleResultSafely(final Query query) {
		T result = null;
		try {
			result = (T) query.getSingleResult();
		}
		catch (NoResultException nsre) {
			// Ignore
		}
		return Optional.ofNullable(result);
	}

	@Override
	public <T> List<T> getUnmodifiableResultList(final CriteriaQuery<T> query) {
		return getUnmodifiableResultList(entityManager().createQuery(query));
	}

	@Override
	public <T> List<T> getUnmodifiableResultList(final TypedQuery<T> query) {
		List<T> results = query.getResultList();
		return results != null && !results.isEmpty() ? Collections.unmodifiableList(results) : Collections.emptyList();
	}

	@Override
	public <T> T persist(final T entity) {
		entityManager().persist(entity);
		return entity;
	}

	@Override
	public <T, S> Optional<T> findByIdSafely(final Class<T> clazz, final S primaryKey) {
		return Optional.ofNullable(entityManager().find(clazz, primaryKey));
	}

	@Override
	public <T, S> T getReference(final Class<T> clazz, final S primaryKey) {
		return this.entityManager.getReference(clazz, primaryKey);
	}

}
