using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Murder : MonoBehaviour {

	private GameObject player;

	// Use this for initialization
	void Awake () {
		player = GameObject.FindGameObjectWithTag ("Player");
	}
	
	// Update is called once per frame
	void Update () {
		//nothing important here
	}

	void OnTriggerEnter (Collider other) {
		if (other.gameObject == player) {
			//if the player enters the trigger
		}//if
	}//OnTriggerEnter
}
