package com.monitorjbl.json;

import java.util.HashMap;
import java.util.Map;

/**
 * Allows runtime alteration of JSON responses
 */
public class JsonView<T> {
  protected final T value;
  protected final Map<Class<?>, Match> matches = new HashMap<>();
  protected MatcherBehavior matcherBehavior;

  protected JsonView(T value) {
    this.value = value;
  }

  public T getValue() {
    return value;
  }

  Match getMatch(Class<?> cls) {
    return matches.get(cls);
  }

  public JsonView<T> onClass(Class<?> cls, Match match) {
    matches.put(cls, match);
    return this;
  }

  public JsonView<T> withMatcherBehavior(MatcherBehavior matcherBehavior) {
    this.matcherBehavior = matcherBehavior;
    return this;
  }

  public static <E> JsonView<E> with(E value) {
    return new JsonView<>(value);
  }

}
