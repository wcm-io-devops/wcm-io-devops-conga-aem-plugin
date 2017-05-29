/*
 * #%L
 * wcm.io
 * %%
 * Copyright (C) 2015 wcm.io
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package io.wcm.devops.conga.plugins.aem.postprocessor;

/**
 * Option property names for content package post processors {@link ContentPackagePostProcessor} and
 * {@link ContentPackageOsgiConfigPostProcessor}.
 */
public final class ContentPackageOptions {

  private ContentPackageOptions() {
    // constants only
  }

  /**
   * Group name for content package
   */
  public static final String PROPERTY_PACKAGE_GROUP = "contentPackage.group";

  /**
   * Package name for content package
   */
  public static final String PROPERTY_PACKAGE_NAME = "contentPackage.name";

  /**
   * Description for content package
   */
  public static final String PROPERTY_PACKAGE_DESCRIPTION = "contentPackage.description";

  /**
   * Version for content package
   */
  public static final String PROPERTY_PACKAGE_VERSION = "contentPackage.version";

  /**
   * Root path for content package (simplified version for setting just one filter)
   */
  public static final String PROPERTY_PACKAGE_ROOT_PATH = "contentPackage.rootPath";

  /**
   * Contains list with filter definitions, optionally with include/exclude rules
   */
  public static final String PROPERTY_PACKAGE_FILTERS = "contentPackage.filters";

  /**
   * Access control handling for content package.
   */
  public static final String PROPERTY_PACKAGE_AC_HANDLING = "contentPackage.acHandling";

  /**
   * URL to thumbnail PNG image to be used for the content package.
   * URL file plugin prefixes can be used (e.g. classpath:).
   */
  public static final String PROPERTY_PACKAGE_THUMBNAIL_IMAGE = "contentPackage.thumbnailImage";

}
