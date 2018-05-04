using System.Collections;
using System.Collections.Generic;
﻿using UnityEngine;

public class GameOverManager : Pathfinding
{
	Animator anim;
	public GameObject player;
	private GridPlayer p;

	void Awake()
	{
		anim = GetComponent<Animator>();
		player = GameObject.FindGameObjectWithTag ("Player");
		p = player.GetComponent<GridPlayer> ();
	}


	void Update()
	{
		if (p.isDead)
		{
			anim.SetTrigger("GameOver");
		}
	}
}