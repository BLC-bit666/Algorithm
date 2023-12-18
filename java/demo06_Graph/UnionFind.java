package demo06_Graph;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

/**
 * @BelongsProject: algorithm
 * @CreateTime: 2023-12-03  11:24
 * @Author: lanai
 * @Description: 并查集实现
 */
public class UnionFind {
    public static class Element<V>{
        V value;

        public Element(V value) {
            this.value = value;
        }

        // region 重写的 equals 与 hashCode 方法
        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Element<?> element = (Element<?>) o;
            return Objects.equals(value, element.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }
        // endregion
    }

    public static class UnionFindSet<V>{
        /**
         * 将用到的类型封装在 element 中，用于统一处理（扩展功能）
         */
        public HashMap<V,Element<V>> elementMap;
        /**
         * 每个元素的父级元素，（初始化为自己），合并后（Union）应为本集合中最顶级元素
         */
        public HashMap<Element<V>,Element<V>> fatherMap;
        /**
         * 各个集合中的（唯一）顶级元素与其集合中的元素个数的映射关系
         */
        public HashMap<Element<V>,Integer> rankMap;

        /**
         * 将所有元素初始化到并查集
         * @param list
         */
        public UnionFindSet(List<V> list) {
            elementMap = new HashMap<>();
            fatherMap = new HashMap<>();
            rankMap = new HashMap<>();
            for (V value : list) {
                Element<V> element = new Element<>(value);
                elementMap.put(value, element);
                fatherMap.put(element, element);
                rankMap.put(element, 1);
            }
        }

        /**
         * 不对为暴漏的方法，只用于实现本类中其他方法的功能
         * 查找该元素对应的顶级元素（本集合中最顶级的元素），并将路径上的所有元素的父级设置为顶级元素（提高后续查找速率）
         * @param element
         * @return
         */
        private Element<V> findHead(Element<V> element) {
            Stack<Element<V>> path = new Stack<>();
            while (element != fatherMap.get(element)) {
                path.push(element);
                element = fatherMap.get(element);
            }
            while (!path.isEmpty()) {
                fatherMap.put(path.pop(), element);
            }
            return element;
        }

        /**
         * 判断两元素是否在用以集合
         * @param a
         * @param b
         * @return
         */
        public boolean isSameSet(V a, V b) {
            if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
                return findHead(elementMap.get(a)) == findHead(elementMap.get(b));
            }
            return false;
        }

        /**
         * 将两元素各自所在的集合合并
         * @param a
         * @param b
         */
        public void union(V a, V b) {
            if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
                Element<V> aF = findHead(elementMap.get(a));
                Element<V> bF = findHead(elementMap.get(b));
                if (aF != bF) {
                    Element<V> big = rankMap.get(aF) >= rankMap.get(bF) ? aF : bF;
                    Element<V> small = big == aF ? bF : aF;
                    fatherMap.put(small, big);
                    rankMap.put(big, rankMap.get(aF) + rankMap.get(bF));
                    rankMap.remove(small);
                }
            }
        }
    }
}
