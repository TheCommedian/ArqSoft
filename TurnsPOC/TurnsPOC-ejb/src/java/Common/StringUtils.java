/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

/**
 *
 * @author Marcelo Barberena / Fernando Maidana
 */
public class StringUtils {
    
    private static final String CANNOT_BE_EMPTY = "{0} {1} cannot be an empty string";
    private static final String CANNOT_BE_NULL = "{0} {1} cannot be an empty string";
    
    public static void validateNotNullOrEmpty(String text) throws IllegalArgumentException
    {
        validateNotNullOrEmpty(text, null);
    }
   
    public static void validateNotNullOrEmpty(String text, String parameterName) throws IllegalArgumentException
    {
        String message;
        
        if(text == null)
        {
            message = parameterName == null ? 
                    String.format(CANNOT_BE_NULL, "Text", "") :
                    String.format(CANNOT_BE_NULL, "Parameter", parameterName);
            
            throw new IllegalArgumentException(message);
        }
        
        if(text.equals(""))
        {
            message = parameterName == null ? 
                    String.format(CANNOT_BE_EMPTY, "Text", "") :
                    String.format(CANNOT_BE_EMPTY, "Parameter", parameterName);
            
            throw new IllegalArgumentException(message);
        }
    }
}
