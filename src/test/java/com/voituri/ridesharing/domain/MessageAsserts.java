package com.voituri.ridesharing.domain;

import static com.voituri.ridesharing.domain.AssertUtils.zonedDataTimeSameInstant;
import static org.assertj.core.api.Assertions.assertThat;

public class MessageAsserts {

    /**
     * Asserts that the entity has all properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertMessageAllPropertiesEquals(Message expected, Message actual) {
        assertMessageAutoGeneratedPropertiesEquals(expected, actual);
        assertMessageAllUpdatablePropertiesEquals(expected, actual);
    }

    /**
     * Asserts that the entity has all updatable properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertMessageAllUpdatablePropertiesEquals(Message expected, Message actual) {
        assertMessageUpdatableFieldsEquals(expected, actual);
        assertMessageUpdatableRelationshipsEquals(expected, actual);
    }

    /**
     * Asserts that the entity has all the auto generated properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertMessageAutoGeneratedPropertiesEquals(Message expected, Message actual) {
        assertThat(expected)
            .as("Verify Message auto generated properties")
            .satisfies(e -> assertThat(e.getId()).as("check id").isEqualTo(actual.getId()));
    }

    /**
     * Asserts that the entity has all the updatable fields set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertMessageUpdatableFieldsEquals(Message expected, Message actual) {
        assertThat(expected)
            .as("Verify Message relevant properties")
            .satisfies(e -> assertThat(e.getContent()).as("check content").isEqualTo(actual.getContent()))
            .satisfies(
                e ->
                    assertThat(e.getTimestamp())
                        .as("check timestamp")
                        .usingComparator(zonedDataTimeSameInstant)
                        .isEqualTo(actual.getTimestamp())
            );
    }

    /**
     * Asserts that the entity has all the updatable relationships set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertMessageUpdatableRelationshipsEquals(Message expected, Message actual) {
        assertThat(expected)
            .as("Verify Message relationships")
            .satisfies(e -> assertThat(e.getRide()).as("check ride").isEqualTo(actual.getRide()));
    }
}
