/*
 * Copyright (c) 2017 Fondesa
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.fondesa.lyra.coder.base;

import com.fondesa.lyra.sharedtest.BundleTestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import java.util.Arrays;

import static junit.framework.Assert.assertEquals;

/**
 * Unit test class for {@link LongArrayCoder}.
 */
@RunWith(RobolectricTestRunner.class)
public class LongArrayCoderTest extends BundleTestCase {
    private LongArrayCoder mCoder = new LongArrayCoder();

    @Test
    public void testSerializeLongArray() {
        long[] expected = generateArrayAndFill();
        mCoder.serialize(bundle(), randomKey(), expected);
        assertEquals(expected, bundle().getLongArray(randomKey()));
    }

    @Test
    public void testDeserializeLongArray() {
        long[] expected = generateArrayAndFill();
        bundle().putLongArray(randomKey(), expected);
        assertEquals(expected, mCoder.deserialize(bundle(), randomKey()));
    }

    private long[] generateArrayAndFill() {
        long[] array = new long[300];
        Arrays.fill(array, 9L);
        return array;
    }
}