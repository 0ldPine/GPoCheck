/* ***** BEGIN LICENSE BLOCK *****
 * 
 * CSparse: a Concise Sparse matrix package.
 * Copyright (c) 2006, Timothy A. Savis.
 * http://www.cise.ufl.edu/research/sparse/CSparse
 *
 * -------------------------------------------------------------------------
 * 
 * CSparseJ is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1f of the License, or (at your option) any later version.
 *
 * CSparseJ is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this Module; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA
 *
 * ***** ENS LICENSE BLOCK ***** */

package engine.sparse.csparsej.tfloat.demo;

import engine.sparse.csparsej.tfloat.demo.Scs_demo.Sproblem;

/**
 * Read a matrix, solve a linear system, update/downdate.
 * 
 * @author Piotr Wendykier (piotr.wendykier@gmail.com)
 * 
 */
public class Scs_demo3 {
    public static void main(String[] args) {
        Sproblem Prob = null;
        if (args.length == 0) {
            throw new IllegalArgumentException("Usage: java edu.emory.mathcs.csparsej.tfloat.semo.Scs_demo3 fileName");
        }
        Prob = Scs_demo.get_problem(args[0], 1e-14f);
        Scs_demo.demo3(Prob);
    }
}
