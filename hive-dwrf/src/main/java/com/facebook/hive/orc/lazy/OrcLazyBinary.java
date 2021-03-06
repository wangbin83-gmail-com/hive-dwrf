//  Copyright (c) 2013, Facebook, Inc.  All rights reserved.

/**
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

package com.facebook.hive.orc.lazy;

import org.apache.hadoop.io.BytesWritable;

public class OrcLazyBinary extends OrcLazyObject {

  public OrcLazyBinary(LazyBinaryTreeReader treeReader) {
    super(treeReader);
  }

  public OrcLazyBinary(OrcLazyBinary copy) {
    super(copy);
    BytesWritable copyPrevious = (BytesWritable) copy.previous;
    byte[] bytes = new byte[copyPrevious.getLength()];
    System.arraycopy(copyPrevious.getBytes(), 0, bytes, 0, copyPrevious.getLength());
    previous = new BytesWritable(bytes);
  }
}
