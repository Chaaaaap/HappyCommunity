using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace HappyCommunity.Types
{
	public class Post : PostOverviewModel
	{
		public string Description { get; set; }
		public int ZipCode { get; set; }
	}
}
