/*
 * This file has been modified from the original.
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package software.amazon.kinesis.connectors.flink;

import org.apache.flink.annotation.PublicEvolving;

import java.util.UUID;

/**
 * A {@link KinesisPartitioner} that maps an arbitrary input {@code element} to a random partition
 * ID.
 *
 * @param <T> The input element type.
 */
@PublicEvolving
public final class RandomKinesisPartitioner<T> extends KinesisPartitioner<T> {
	@Override
	public String getPartitionId(T element) {
		return UUID.randomUUID().toString();
	}

	@Override
	public boolean equals(Object o) {
		return o instanceof RandomKinesisPartitioner;
	}

	@Override
	public int hashCode() {
		return RandomKinesisPartitioner.class.hashCode();
	}
}
