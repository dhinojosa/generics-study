package com.xyzcorp


class KotlinBox<T>(val t:T) {
   fun <U> map (f: (T) -> U):KotlinBox<U> {
      return KotlinBox(f(t))
   }
}

object KotlinCollectionUtil {
    fun <M : Comparable<M>> myMax(list:List<M>):M? {
        if(list.isEmpty()) return null;
        var result: M = list.get(0);
        for (item in list) {
           if (item > result) result = item
        }
        return result;
    }
}

object KotlinReification {
    /**
     *     Inline will not create an unnecessary function and will just take the content of the function
     *     and place the body with a block. In the case of reification since it is inline it can
     *     draw from the byte code the type
     *     https://stackoverflow.com/questions/44471284/when-to-use-an-inline-function-in-kotlin
     */
    inline fun <reified N> whoAmI(list:List<N>):String? {
        return N::class.qualifiedName
    }
}