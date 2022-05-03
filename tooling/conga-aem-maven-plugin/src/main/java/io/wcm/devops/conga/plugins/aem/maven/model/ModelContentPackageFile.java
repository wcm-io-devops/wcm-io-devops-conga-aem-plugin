/*
 * #%L
 * wcm.io
 * %%
 * Copyright (C) 2020 wcm.io
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
package io.wcm.devops.conga.plugins.aem.maven.model;

import static org.apache.jackrabbit.vault.packaging.PackageProperties.NAME_GROUP;
import static org.apache.jackrabbit.vault.packaging.PackageProperties.NAME_NAME;
import static org.apache.jackrabbit.vault.packaging.PackageProperties.NAME_PACKAGE_TYPE;
import static org.apache.jackrabbit.vault.packaging.PackageProperties.NAME_VERSION;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import io.wcm.devops.conga.plugins.aem.postprocessor.ContentPackagePropertiesPostProcessor;

/**
 * Represents a content package file generated or referenced by CONGA.
 */
public final class ModelContentPackageFile implements ContentPackageFile, InstallableFile {

  private final File file;

  private final Boolean install;
  private final Boolean force;
  private final Boolean recursive;
  private final Integer delayAfterInstallSec;
  private final Integer httpSocketTimeoutSec;

  private final String name;
  private final String group;
  private final String version;
  private final String packageType;

  private final List<String> variants;

  /**
   * @param file Content package file
   * @param fileData File data
   * @param variants Variants
   */
  @SuppressWarnings("unchecked")
  public ModelContentPackageFile(File file, Map<String, Object> fileData, List<String> variants) {
    this.file = file;

    this.install = (Boolean)fileData.get("install");
    this.force = (Boolean)fileData.get("force");
    this.recursive = (Boolean)fileData.get("recursive");
    this.delayAfterInstallSec = (Integer)fileData.get("delayAfterInstallSec");
    this.httpSocketTimeoutSec = (Integer)fileData.get("httpSocketTimeoutSec");

    Map<String, Object> contentPackageProperties = (Map<String, Object>)fileData.get(
        ContentPackagePropertiesPostProcessor.MODEL_OPTIONS_PROPERTY);
    if (contentPackageProperties == null) {
      throw new IllegalArgumentException(ContentPackagePropertiesPostProcessor.MODEL_OPTIONS_PROPERTY + " missing.");
    }
    this.name = Objects.toString(contentPackageProperties.get(NAME_NAME), null);
    this.group = Objects.toString(contentPackageProperties.get(NAME_GROUP), null);
    this.version = Objects.toString(contentPackageProperties.get(NAME_VERSION), null);
    this.packageType = Objects.toString(contentPackageProperties.get(NAME_PACKAGE_TYPE), null);

    this.variants = variants;
  }

  @Override
  public File getFile() {
    return this.file;
  }

  @Override
  public Boolean getInstall() {
    return this.install;
  }

  public Boolean getForce() {
    return this.force;
  }

  public Boolean getRecursive() {
    return this.recursive;
  }

  public Integer getDelayAfterInstallSec() {
    return this.delayAfterInstallSec;
  }

  public Integer getHttpSocketTimeoutSec() {
    return this.httpSocketTimeoutSec;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public String getGroup() {
    return this.group;
  }

  @Override
  public String getVersion() {
    return this.version;
  }

  @Override
  public String getPackageType() {
    return this.packageType;
  }

  @Override
  public List<String> getVariants() {
    return this.variants;
  }

  @Override
  public String toString() {
    return file.toString();
  }

}
