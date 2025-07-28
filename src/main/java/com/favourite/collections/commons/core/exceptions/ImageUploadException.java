/* Collections #2024 */
package com.favourite.collections.commons.core.exceptions;

public class ImageUploadException extends AbstractPlatformDomainRuleException {

	public ImageUploadException(String badMimeType) {
		super("error.msg.image.type.upload",
				"Only image files of type GIF,PNG and JPG are allowed, but not: " + badMimeType);
	}
}
