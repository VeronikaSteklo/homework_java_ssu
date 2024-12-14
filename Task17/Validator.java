package Task17;

import java.lang.reflect.Field;
import java.lang.annotation.Annotation;


public class Validator {
    public static void validate(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            Object value = getObject(obj, field);

            if (field.isAnnotationPresent(Range.class) && value instanceof Integer) {
                Range range = field.getAnnotation(Range.class);
                int min = range.min();
                int max = range.max();
                int intValue = (Integer) value;
                if (intValue < min || intValue > max) {
                    throw new ValidationException("Поле " + field.getName() + " должно быть в диапазоне от " + min + " до " + max + ".");
                }
            }
        }
    }

    private static Object getObject(Object obj, Field field) throws IllegalAccessException {
        Object value = field.get(obj);

        if (field.isAnnotationPresent(NotNull.class) && value == null) {
            throw new ValidationException("Поле " + field.getName() + " не должно быть null.");
        }

        if (field.isAnnotationPresent(MaxLength.class) && value instanceof String) {
            int maxLength = field.getAnnotation(MaxLength.class).value();
            if (((String) value).length() > maxLength) {
                throw new ValidationException("Поле " + field.getName() + " превышает максимальную длину " + maxLength + ".");
            }
        }

        if (field.isAnnotationPresent(Min.class) && value instanceof Integer) {
            int min = field.getAnnotation(Min.class).value();
            if ((Integer) value < min) {
                throw new ValidationException("Поле " + field.getName() + " должно быть не меньше " + min + ".");
            }
        }
        return value;
    }
}
