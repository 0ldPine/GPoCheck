//==============================================================================
//	
//	Copyright (c) 2002-
//	Authors:
//	* Dave Parker <david.parker@comlab.ox.ac.uk> (University of Oxford, formerly University of Birmingham)
//	
//------------------------------------------------------------------------------
//	
//	This file is part of PRISM.
//	
//	PRISM is free software; you can redistribute it and/or modify
//	it under the terms of the GNU General Public License as published by
//	the Free Software Foundation; either version 2 of the License, or
//	(at your option) any later version.
//	
//	PRISM is distributed in the hope that it will be useful,
//	but WITHOUT ANY WARRANTY; without even the implied warranty of
//	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//	GNU General Public License for more details.
//	
//	You should have received a copy of the GNU General Public License
//	along with PRISM; if not, write to the Free Software Foundation,
//	Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
//	
//==============================================================================

package parse.common;

import java.util.*;
import java.util.Map.Entry;

import engine.simple.SimpleMatrix;

// Class representing parsed model file

public class ModulesFile {

	// Model type (enum)
	private ModelType modelType;

	// Model components
	private Map<String, List<String>> formulaList;
	private Map<String, List<String>> labelList;
	private Map<String, List<String>> constantList;

	// Global variables
	private Map<String, Value<?>> globals;
	// Modules (includes renamed modules)
	private Vector<Object> modules;

	// module names set
	private List<String> moduleNames;
	// module context in this Map
	private Map<String, String> moduleContexts;
	// every module`s state in this Map, key is module name,value
	private Map<String, Map<String, Value<Integer>>> moduleStates;
	// every module`s state translate statement in this Map,one module has one matrix
	private Map<String, SimpleMatrix> moduleTransferMatrix;
	// all lables
	private ArrayList<String> moduleAllLabels;
	// every module`s action in this Map
	private Map<String, List<String>> moduleLabels;
	// every state`s action matrix
	private Map<String, SimpleMatrix> moduleStateLabelMatrix;

	// properties
	private List<GPoProperty> properties;

	private String currentModule;

	// Constructor
	public ModulesFile() {
		formulaList = new HashMap<String, List<String>>();
		labelList = new HashMap<String, List<String>>();
		constantList = new HashMap<String, List<String>>();
		modelType = ModelType.GPKS; // default type
		globals = new HashMap<String, Value<?>>();
		modules = new Vector<Object>();
		moduleNames = new ArrayList<String>();
		moduleContexts = new HashMap<String, String>();
		moduleStates = new HashMap<String, Map<String, Value<Integer>>>();
		moduleTransferMatrix = new HashMap<String, SimpleMatrix>();
		moduleAllLabels = new ArrayList<String>();
		moduleLabels = new HashMap<String, List<String>>();
		moduleStateLabelMatrix = new HashMap<String, SimpleMatrix>();
		properties = new ArrayList<GPoProperty>();
	}

	public Map<String, Value<?>> getGlobals() {
		return globals;
	}

	public void setGlobals(Map<String, Value<?>> globals) {
		this.globals = globals;
	}

	public Map<String, Map<String, Value<Integer>>> getModuleStates() {
		return moduleStates;
	}

	public void setModuleStates(Map<String, Map<String, Value<Integer>>> moduleStates) {
		this.moduleStates = moduleStates;
	}

	public Map<String, String> getModuleContexts() {
		return moduleContexts;
	}

	public void setModuleContexts(Map<String, String> moduleContexts) {
		this.moduleContexts = moduleContexts;
	}

	public ModelType getModelType() {
		return modelType;
	}

	public Map<String, List<String>> getFormulaList() {
		return formulaList;
	}

	public void setFormulaList(Map<String, List<String>> formulaList) {
		this.formulaList = formulaList;
	}

	public Map<String, List<String>> getLabelList() {
		return labelList;
	}

	public void setLabelList(Map<String, List<String>> labelList) {
		this.labelList = labelList;
	}

	public Map<String, List<String>> getConstantList() {
		return constantList;
	}

	public void setConstantList(Map<String, List<String>> constantList) {
		this.constantList = constantList;
	}

	public void setModelType(ModelType modelType) {
		this.modelType = modelType;
	}

	public Vector<Object> getModules() {
		return modules;
	}

	public void setModules(Vector<Object> modules) {
		this.modules = modules;
	}

	public List<String> getModuleNames() {
		return moduleNames;
	}

	public void setModuleNames(List<String> moduleNames) {
		this.moduleNames = moduleNames;
	}

	public Map<String, List<String>> getModuleLabels() {
		return moduleLabels;
	}

	public void setModuleLabels(Map<String, List<String>> moduleLabels) {
		this.moduleLabels = moduleLabels;
	}

	public Map<String, SimpleMatrix> getModuleTransferMatrix() {
		return moduleTransferMatrix;
	}

	public void setModuleTransferMatrix(Map<String, SimpleMatrix> moduleTransferMatrix) {
		this.moduleTransferMatrix = moduleTransferMatrix;
	}

	public String getCurrentModule() {
		return currentModule;
	}

	public void setCurrentModule(String currentModule) {
		this.currentModule = currentModule;
	}

	public Map<String, SimpleMatrix> getModuleStateLabelMatrix() {
		return moduleStateLabelMatrix;
	}

	public void setModuleStateLabelMatrix(Map<String, SimpleMatrix> moduleStateLabelMatrix) {
		this.moduleStateLabelMatrix = moduleStateLabelMatrix;
	}

	public List<GPoProperty> getProperties() {
		return properties;
	}

	public void setProperties(List<GPoProperty> properties) {
		this.properties = properties;
	}

	public ArrayList<String> getModuleAllLabels() {
		return moduleAllLabels;
	}

	public void setModuleAllLabels(ArrayList<String> moduleAllLabels) {
		this.moduleAllLabels = moduleAllLabels;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n====================================================\n");
		sb.append("Detail Info:\n");

		// model type
		sb.append("Model Type is " + modelType + "\n");

		// Modules
		sb.append("----------------------------------------------------\n");
		sb.append("Modules:\n");
		for (int i = 0; i < moduleNames.size(); i++) {
			sb.append("Module" + (i + 1) + "`s Name : " + moduleNames.get(i) + "\n");
			sb.append(moduleContexts.get(moduleNames.get(i)) + "\n");
			// module vars
			sb.append("-----module vars------\n");
			Iterator<Entry<String, Value<Integer>>> moduleVariter = moduleStates.get(moduleNames.get(i)).entrySet().iterator();
			while (moduleVariter.hasNext()) {
				Entry<String, Value<Integer>> entry = moduleVariter.next();
				sb.append(entry.getKey() + " type:" + entry.getValue().getType() + " currentValue:" + entry.getValue().getValue() + " min:" + entry.getValue().getMin() + " max:" + entry.getValue().getMax() + "\n");
			}
			sb.append("-----module matrix----\n");
			sb.append(moduleTransferMatrix.get(moduleNames.get(i)).toString());
			sb.append("-----module labels----\n");
			sb.append("Labels Set [");
			for (int j = 0; j < moduleLabels.get(moduleNames.get(i)).size(); j++) {
				sb.append(" " + moduleLabels.get(moduleNames.get(i)).get(j));
			}
			sb.append("]\n");
			sb.append(moduleStateLabelMatrix.get(moduleNames.get(i).toString()));
			sb.append("----------------------------------------------------\n");
		}

		// All Labels
		sb.append("Labels:\n");
		if (moduleAllLabels.size() > 0) {
			for (String str : moduleAllLabels) {
				sb.append(str + " ");
			}
			sb.append("\n");
		} else {
			sb.append("No Labels\n");
		}
		sb.append("----------------------------------------------------\n");

		// Global variables
		sb.append("Global variables:\n");
		Iterator<Entry<String, Value<?>>> globalVariter = globals.entrySet().iterator();
		if (globalVariter.hasNext()) {
			while (globalVariter.hasNext()) {
				Map.Entry<String, Value<?>> entry = globalVariter.next();
				sb.append(entry.getKey() + " " + entry.getValue().getType() + " " + entry.getValue().getValue() + "\n");
			}
		} else {
			sb.append("No GlobalVars\n");
		}
		sb.append("----------------------------------------------------\n");

		// Properties
		sb.append("Properties:\n");
		if (properties.size() > 0) {
			for (GPoProperty property : properties) {
				sb.append(property.toString() + "\n");
				if(!"".equals(property.getResult())){
					sb.append("result:\n");
					sb.append(property.getResult() + "\n");
				}
			}
		} else {
			sb.append("No Properties\n");
		}
		sb.append("====================================================\n");

		return sb.toString();
	}
}

// ------------------------------------------------------------------------------
