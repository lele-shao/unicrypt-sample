/*
 * UniCrypt
 *
 *  UniCrypt(tm) : Cryptographical framework allowing the implementation of cryptographic protocols e.g. e-voting
 *  Copyright (C) 2014 Bern University of Applied Sciences (BFH), Research Institute for
 *  Security in the Information Society (RISIS), E-Voting Group (EVG)
 *  Quellgasse 21, CH-2501 Biel, Switzerland
 *
 *  Licensed under Dual License consisting of:
 *  1. GNU Affero General Public License (AGPL) v3
 *  and
 *  2. Commercial license
 *
 *
 *  1. This program is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU Affero General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU Affero General Public License for more details.
 *
 *   You should have received a copy of the GNU Affero General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 *
 *  2. Licensees holding valid commercial licenses for UniCrypt may use this file in
 *   accordance with the commercial license agreement provided with the
 *   Software or, alternatively, in accordance with the terms contained in
 *   a written agreement between you and Bern University of Applied Sciences (BFH), Research Institute for
 *   Security in the Information Society (RISIS), E-Voting Group (EVG)
 *   Quellgasse 21, CH-2501 Biel, Switzerland.
 *
 *
 *   For further information contact <e-mail: unicrypt@bfh.ch>
 *
 *
 * Redistributions of files must retain the above copyright notice.
 */
package ch.bfh.unicrypt.math.algebra.multiplicative;

import ch.bfh.unicrypt.Example;
import ch.bfh.unicrypt.helper.prime.SafePrime;
import ch.bfh.unicrypt.math.algebra.general.interfaces.Element;
import ch.bfh.unicrypt.math.algebra.multiplicative.classes.GStarModSafePrime;
import java.math.BigInteger;

/**
 *
 * @author Rolf Haenni <rolf.haenni@bfh.ch>
 */
public class GStarModSafePrimeExample {

	public static void example1() {

		GStarModSafePrime group = GStarModSafePrime.getInstance(59);

		// Compute order (59-1)/2 = 29
		BigInteger order = group.getOrder();

		// Multiply two group elements: 3*27 mod 59 = 22
		Element e1 = group.getElement(3);
		Element e2 = group.getElement(27);
		Element e12 = group.multiply(e1, e2);

		// Select and apply default generator
		Element generator = group.getDefaultGenerator();
		Element result = group.power(generator, 5);

		Example.printLine("Group", group);
		Example.printLine("Order", order);
		Example.printLines("Elements 3, 27, 3*27", e1, e2, e12);
		Example.printLines("Generator and power", generator, result);

		Example.printLine("All Elements:");
		for (Element element : group.getElements()) {
			Example.printLine(element);
		}

	}

	public static void example2() {

		int bitLength = 128;

		// Create random groups
		GStarModSafePrime group = GStarModSafePrime.getInstance(SafePrime.getSmallestInstance(bitLength));

		// Get order
		BigInteger order = group.getOrder();

		// Select default generator
		Element generator = group.getDefaultGenerator();

		Example.printLine("Group", group);
		Example.printLine("Order", order);
		Example.printLines("Generator", generator);

	}

	public static void main(final String[] args) {
		Example.runExamples();
	}

}
