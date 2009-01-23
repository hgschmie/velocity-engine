package org.apache.velocity.test.issues;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.    
 */

import org.apache.velocity.test.BaseEvalTestCase;
import org.apache.velocity.runtime.RuntimeConstants;

/**
 * This class tests VELOCITY-682. 
 */
public class Velocity682TestCase extends BaseEvalTestCase
{
    public Velocity682TestCase(String name)
    {
        super(name);
        DEBUG=true;
    }
  
    public void test682()
    {
      engine.setProperty(RuntimeConstants.VM_PERM_INLINE_LOCAL, true);      
      //assertEvalEquals("foo1foo2", "#macro(eval $e)#evaluate($e)#end#eval('foo1')#eval('foo2')");
    }

    public void test682b()
    {
        String template = "#macro( eval $e )#evaluate($e)#end" +
                          "#eval('foo')" +
                          "#eval('bar')";
        String expected = "foo"+
                          "bar";
        assertEvalEquals(expected, template);
    }

    public void test682c()
    {
        String template = "#macro( eval $e )#evaluate($e)#end" +
                          "\n#eval('foo')" +
                          "\n#eval('bar')";
        String expected = "\nfoo"+
                          "\nbar";
        //assertEvalEquals(expected, template);
    }
}
