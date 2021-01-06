/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3007.groupproject;

import java.util.Iterator;
import java.util.Stack;

/**
 *
 * @author ganze
 */
public class AcquaintanceIterator implements Iterator {

    Stack<Iterator> stack = new Stack();

    public AcquaintanceIterator(Iterator iterator) {
        stack.push(iterator);
    }

    @Override
    public boolean hasNext() {
        if (stack.empty()) {
            return false;
        } else {
            Iterator iterator = stack.peek();
            if (!iterator.hasNext()) {
                stack.pop();
                return hasNext();
            } else {
                return true;
            }
        }
    }

    @Override
    public AcquaintanceComponent next() {
        if (hasNext()) {
            Iterator<AcquaintanceComponent> iterator = stack.peek();
            AcquaintanceComponent component = iterator.next();

            if (component instanceof AcquaintanceList) {
                stack.push(((AcquaintanceList) component).createIterator());
            }
            return component;
        } else {
            return null;
        }
    }
}
