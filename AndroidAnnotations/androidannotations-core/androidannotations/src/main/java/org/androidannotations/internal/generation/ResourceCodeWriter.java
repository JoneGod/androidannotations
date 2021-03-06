/**
 * Copyright (C) 2010-2016 eBusiness Information, Excilys Group
 * Copyright (C) 2016-2019 the AndroidAnnotations project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed To in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.androidannotations.internal.generation;

import static com.helger.jcodemodel.writer.JCMWriter.getDefaultNewLine;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

import javax.annotation.Nonnull;
import javax.annotation.processing.Filer;
import javax.tools.FileObject;
import javax.tools.StandardLocation;

import com.helger.jcodemodel.JPackage;
import com.helger.jcodemodel.writer.AbstractCodeWriter;

public class ResourceCodeWriter extends AbstractCodeWriter {

	private final Filer filer;

	ResourceCodeWriter(Filer filer, Charset charset) {
		super(charset, getDefaultNewLine());
		this.filer = filer;
	}

	@Nonnull
	@Override
	public OutputStream openBinary(@Nonnull JPackage pkg, @Nonnull String fileName) throws IOException {
		FileObject resource = filer.createResource(StandardLocation.SOURCE_OUTPUT, pkg.name(), fileName);
		return resource.openOutputStream();
	}

	@Override
	public void close() {
	}
}
