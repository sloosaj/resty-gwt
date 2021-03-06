/**
 * Copyright (C) 2011 the original author or authors.
 * See the notice.md file distributed with this work for additional
 * information regarding copyright ownership.
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
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, is strictly prohibited.
 */
package org.fusesource.restygwt.server.complex;

import org.codehaus.jackson.map.ObjectMapper;
import org.fusesource.restygwt.client.complex.BigIntegerDto;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Jeff Larsen
 */
public class BigIntegerDtoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        BigIntegerDto dto = mapper.readValue(request.getInputStream(), BigIntegerDto.class);

        List<BigInteger> ints = dto.getInts();
        BigInteger bi0 = ints.get(0);
        BigInteger bi1 = ints.get(1);
        BigInteger bi2 = ints.get(2);

        ints = new ArrayList<BigInteger>();

        ints.add(bi2);
        ints.add(bi1);
        ints.add(bi0);

        dto.setInts(ints);

        mapper.writeValue(response.getWriter(), dto);

    }
}
