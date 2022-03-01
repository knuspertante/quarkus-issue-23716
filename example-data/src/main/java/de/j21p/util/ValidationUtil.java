package de.j21p.util;

import java.util.Collection;
import java.util.Objects;

public class ValidationUtil {

  public static void checkAttribute(String name, String value, boolean checkForEmpty)
      throws ValidationException {
    if (Objects.isNull(value) || (checkForEmpty && value.isBlank())) {
      throw new ValidationUtil.ValidationException(
          String.format(
              "Notwendiges Attribut %s fehlt, ist leer oder \"null\", beachte ebenso leere Collections wie z. B. List: %s",
              name, value));
    }
  }

  public static void checkAttribute(String name, Collection value, boolean checkForItems)
      throws ValidationException {
    if (Objects.isNull(value) || (checkForItems && value.size() == 0)) {
      throw new ValidationUtil.ValidationException(
          String.format(
              "Notwendiges Attribut %s fehlt, ist leer oder \"null\", beachte ebenso leere Collections wie z. B. List: %s",
              name, value));
    }
  }

  public static void checkAttribute(String name, Object value) throws ValidationException {
    if (Objects.isNull(value)) {
      throw new ValidationUtil.ValidationException(
          String.format(
              "Notwendiges Attribut %s fehlt, ist leer oder \"null\", beachte ebenso leere Collections wie z. B. List: %s",
              name, null));
    }
  }

  public static class ValidationException extends RuntimeException {

    public ValidationException(String message) {
      super(message);
    }

    public ValidationException(String message, Throwable cause) {
      super(message, cause);
    }

    public ValidationException(Throwable cause) {
      super(cause);
    }

    protected ValidationException(
        String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
      super(message, cause, enableSuppression, writableStackTrace);
    }
  }
}
