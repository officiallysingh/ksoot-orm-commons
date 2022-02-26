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

package com.ksoot.orm.envers;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Rajveer Singh
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "REVINFO", indexes = { @Index(name = "IDX_REVINFO_DATE_TIME", columnList = "DATE_TIME")})
@RevisionEntity(RevisionEntityListener.class)
public class RevisionInfo extends DefaultRevisionEntity {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Column(name = "ACTOR", updatable = false, nullable = false)
    private String actor;

    @NotNull
    @Column(name = "DATE_TIME", updatable = false, nullable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP")
    private OffsetDateTime datetime;
}