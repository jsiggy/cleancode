package com.siggy.training.code.smells.smellections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MapTest {
	private Map empty;
	private Map oneElement;
	private Map manyElement;

	@BeforeEach
	public void setUp() {
		empty = new Map();
		oneElement = new Map();
		oneElement.add("CA", "California");
		manyElement = new Map();
		manyElement.add("NY", "New York");
		manyElement.add("OR", "Oregon");
	}

	@Test
	public void isEmpty() {
		assertTrue(empty.isEmpty());
		assertTrue(!oneElement.isEmpty());
	}

	@Test
	public void size() {
		assertEquals(0, empty.size());
		assertEquals(1, oneElement.size());
		assertTrue(manyElement.size() > 1);
	}

	@Test
	public void getWhenKeyInMap() {
		assertEquals("California", oneElement.get("CA"));
	}

	@Test
	public void getWhenKeyNotInMap() {
		assertEquals(null, oneElement.get("AZ"));
	}

	@Test
	public void getAfterEntryRemoved() {
		manyElement.remove("NY");
		assertEquals(null, manyElement.get("NY"));
	}

	@Test
	public void contains() {
		assertTrue(manyElement.contains("Oregon"));
		assertTrue(!manyElement.contains("California"));
	}

	@Test
	public void containsWhenValueIsNull() {
		oneElement.add("MI", null);
		assertTrue(oneElement.contains(null));
	}

	@Test
	public void addIgnoresValueWhenKeyIsNull() {
		oneElement.add(null, "No Value");
		assertEquals(null, oneElement.get(null));
	}

	@Test
	public void containsKey() {
		assertTrue(manyElement.containsKey("OR"));
		assertTrue(!manyElement.containsKey("CA"));
	}

	@Test
	public void addOverridesExistingEntry() {
		oneElement.add("CA", "Calistoga");
		assertEquals(1, oneElement.size());
		assertEquals("Calistoga", oneElement.get("CA"));
	}

	@Test
	public void remove() {
		assertTrue(oneElement.remove("CA"));
		assertEquals(0, oneElement.size());
		assertTrue(manyElement.remove("NY"));
		assertEquals(1, manyElement.size());
	}

	@Test
	public void addAll() {
		oneElement.addAll(manyElement);
		assertEquals(3, oneElement.size());
	}

	@Test
	public void addAllWithDuplicates() {
		Map mapWithDuplicates = new Map();
		mapWithDuplicates.add("NY", "New York");
		manyElement.addAll(mapWithDuplicates);
		assertEquals(2, manyElement.size());
	}

	@Test
	public void expandability() {
		Map expandableMap = new Map();
		assertEquals(10, expandableMap.capacity());
		for (int i = 0; i < 11; i++)
			expandableMap.add(i, "" + i);
		assertEquals(11, expandableMap.size());
		assertEquals(20, expandableMap.capacity());
	}

	@Test
	public void readOnlyOnAdd() {
		oneElement.setReadOnly(true);
		oneElement.add("WI", "Wisconsin");
		assertEquals(1, oneElement.size());
	}

	@Test
	public void readOnlyOnRemove() {
		oneElement.setReadOnly(true);
		oneElement.remove("CA");
		assertEquals(1, oneElement.size());
	}

	@Test
	public void readOnlyOnAddAll() {
		oneElement.setReadOnly(true);
		oneElement.addAll(manyElement);
		assertEquals(1, oneElement.size());
	}
}
